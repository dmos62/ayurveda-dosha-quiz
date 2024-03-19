(ns myproject.state
    (:require
      [cljs.reader :refer [read-string]]
      [reagent.format :refer [format]]
      [myproject.data :as data]
      [reagent.core :as r]
      [reagent.debug :as debug]
      [reagent.dom :as d]))

(defn get-random-question-order [questions]
  (->>
    questions
    (map :id)
    shuffle
    )
  )

(defn get-random-option-order-for-question [question]
  (let [id (:id question)
        random-option-order (shuffle [0 1 2])]
    {id random-option-order}
    )
  )

(defn get-random-option-order [questions]
  (->>
    questions
    (map get-random-option-order-for-question)
    (apply merge)
    )
  )

(def version 1)

(def local-storage-key "state")

(defn serialize-state [state]
  (pr-str state)
  )

(defn deserialize-state [edn-string]
  (read-string edn-string)
  )

(defn get-persisted-state []
  (->
    (.getItem (.-localStorage js/window) local-storage-key)
    deserialize-state
    )
  )

(defn get-query-string []
  (.. js/window -location -search)
  )

(defn obfuscate-state [state]
  (-> state serialize-state js/btoa)
  )

(defn deobfuscate-state [obfuscated-state]
  (-> obfuscated-state js/atob deserialize-state)
  )

(defn get-query-string-state []
  (->
    (get-query-string)
    (subs 1) ; trim the initial question-mark
    deobfuscate-state
  ))

(defn get-location-without-query []
  (let [location (. js/window -location)]
    (str (. location -origin) (. location -pathname))
    )
  )

(defn remove-query-string! []
  (.. js/window -location (replace (get-location-without-query)))
  )

(defn get-initial-state! []
  (let [persisted-state (get-persisted-state)
        persisted-version (:version persisted-state)
        query-string-state (get-query-string-state)
        query-string-version (:version query-string-state)
        ]
    (debug/prn 'persisted-state persisted-state)
    (debug/prn 'persisted-version persisted-version)
    (cond
      ; qs state will get immediately persisted by persistor tracker
      (= version query-string-version) (do
                                         (remove-query-string!)
                                         query-string-state
                                         )
      (= version persisted-version) persisted-state
      true {
       :active-page :home-page
       :answers data/default-answers
       :question-order (get-random-question-order data/quiz)
       :option-order (get-random-option-order data/quiz)
       :quiz-finished false
       :version version
       }
      )
    )
  )

(def global-state (r/atom (get-initial-state!)))

(defn persist-state! []
  (let [edn-str (serialize-state @global-state)]
    (.setItem (.-localStorage js/window) local-storage-key edn-str)
    )
  )

(defonce persistor (r/track! persist-state!))

(def obfuscated-global-state (r/reaction (obfuscate-state @global-state)))

(def link-with-obfuscated-state
  (r/reaction
    (str
      (get-location-without-query)
      "?"
      @obfuscated-global-state
      )))

(def active-page (r/cursor global-state [:active-page]))

(def question-order (r/cursor global-state [:question-order]))

(def option-order (r/cursor global-state [:option-order]))

(def answers (r/cursor global-state [:answers]))

(def totals (r/reaction (->> @answers vals (apply merge-with +))))

(defn format-number [number]
  (format "%.1f" number)
  )

(defn to-percentage-of [y x]
  (let [y (if (= y 0) 1 y)]
    (* 100 (/ x y))
    )
  )

(defn format-percentage [number]
  (str (format-number number) "%")
  )

(def percentages
  (r/reaction 
    (let [totals @totals
          totals-sum (->> totals vals (apply +))]
      (update-vals totals #(to-percentage-of totals-sum %))
    )))

(def percentages-str (r/reaction (update-vals @percentages format-percentage)))

(def totals-str (r/reaction (update-vals @totals format-number)))

(defn log-totals []
  (debug/prn @totals-str)
  )

;(defonce logger (r/track! log-totals))

(defn clear-local-storage! []
    (.clear (.-localStorage js/window))
  )

(defn clear-state! []
  (clear-local-storage!)
  (reset! global-state (get-initial-state!))
  )
