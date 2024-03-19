(ns myproject.views
    (:require
      [reagent.debug :as debug]
      [myproject.data :as data]
      [myproject.state :as state]
      [reagent.core :as r]
      [reagent.dom :as d]))

;; -------------------------
;; Controllers

(defn str-to-number [string]
  (js/parseFloat string)
  )

(defn set-option-value-to-slider! [value-cursor slider-input-el]
  (->>
    slider-input-el
    .-target
    .-value
    str-to-number
    (reset! value-cursor)
    )
  )

;; -------------------------
;; Views

(defn primary-button [on-click label]
   [:button
    {
     :class "bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
     :on-click on-click
     }
    label
    ]
  )

(defn render-slider [input-id value-cursor]
  (let []
    [:div {:class ""}
     [:input {
              :id input-id
              :type "range"
              :min 0
              :max 1
              :step 0.2
              :value @value-cursor
              :on-change #(set-option-value-to-slider! value-cursor %)
              :class "w-full -mb-1.5"; h-2 rounded-lg"
                     ;appearance-none cursor-pointer dark:bg-gray-700"
              }]
     ]
    )
  )

(defn render-option [option]
  (let [
        dosha (:dosha option)
        question-id (:question-id option)
        value-cursor (r/cursor state/answers [question-id dosha])
        text (:text option)
        input-id (random-uuid)
        ]
    [:div {:class "grid gap-4 grid-cols-2 text-right"} [:label {:class "" :for input-id}
      text]
     [render-slider input-id value-cursor]
     ]
    )
  )

(defn reorder-options [option-order options]
  (map #(get options %) option-order)
  )

(defn render-question [question]
  (let [{:keys [title, type, id, kapha, pitta, vata]} question
        options [{:dosha :kapha :text kapha :question-id id}
                 {:dosha :pitta :text pitta :question-id id}
                 {:dosha :vata :text vata :question-id id}]
        option-order (r/cursor state/option-order [id])
        options (reorder-options @option-order options)]
    [:div {:class ""}
     [:h4 {:class "italic text-black/80"} title]
     ;[:h3 {:class "text-black/50 italic"} type]
     [:div {:class "mb-4"}]
     [:div {:class "grid gap-4 grid-cols-2"}
      [:div {:class "
             col-start-2 col-span-1
             grid grid-cols-2 justify-items-stretch"}
       [:div {:class "
               block justify-self-start
               text-sm text-gray-500 dark:text-gray-400"}
        "Very untrue"
        ]
       [:div {:class "
               block justify-self-end
               text-sm text-gray-500 dark:text-gray-400"}
        "Very true"
        ]
       ]
      ]
     [:div {:class "grid gap-2"}
      (for [option options]
        ^{:key (:dosha option)} [render-option option]
        )]]))

(defn reorder-quiz [question-order quiz]
  (map #(nth quiz %) question-order)
  )

(defn link [attrs text]
  (let [attrs (merge 
                {
                 :class "text-blue-600"
                 }
                attrs)]
    [:a attrs text]
    ))

(defn render-results []
  (let [{:keys [vata pitta kapha]} @state/percentages-str
        link-with-state @state/link-with-obfuscated-state]
    [:div {:class "min-h-screen"}
     [:div {:class "grid grid-cols-1 gap-2 min-h-0"}
      [:h2 {:class "italic mb-4"} "Results"]
      [:p
       "Below are the per-dosha sum totals expressed as percetanges of the combined total obtained by your scoring of the above statements. These percentages should help you answer the following questions:"
       ]
      [:p
       "Which dosha is your dominant one? How dominant is your dominant dosha? Do you have two dominants doshas, or just a single one?"
       ]
      [:p
       [link {:href link-with-state} "Copy this link"]
       " if you'd like to save your answers for future reference or continue the questionnaire on another device. Note, your answers are already saved on this browser, until either the Reset button is hit or the browser data is cleared."
       ]
      [:span {:class "mt-4"} (str "Vata: " vata)]
      [:span (str "Pitta: " pitta)]
      [:span (str "Kapha: " kapha)]
      ]
     ]
    )
  )

(defn questions []
  (let [shuffled-quiz (reorder-quiz @state/question-order data/quiz)]
    [:div {:class "grid gap-12 grid-cols-1"}
     (for [question shuffled-quiz]
       ^{:key (:id question)} [render-question question]
       )
     ]))

(defn header []
  [:div {:class "text-center grid gap-4"}
   [:h1 {:class "text-xl font-semibold"} "Ayurvedic Constitutional Test"]
   [:p {}
    "The purpose of this questionnaire is to help you tell which doshas (Vata, Pitta, Kapha) are dominant in your constitution. Taken from the venerable book "
    [link
     {:href "https://www.amazon.com/dp/091026130X"}
     "Yoga for Your Type"]
    ", by Dr. David Frawley and Sandra Summerfield Kozak, to whom I have no affiliation."
    ]
   [:p
    "I made this app-version of the test found in the book, because other online dosha tests I ran into seemed significantly less exhaustive and thus less accurate. Also, I wanted to minimize bias by randomizing the order of the questions and the order of the options."
    ]
   [:h2 {:class "text-xl font-semibold"} "Instructions"]
   [:p
    "Use sliders next to statements to score how true or untrue they are for you. The results are at the bottom of the page. The results update whenever a slider is moved."
    ]
   [:p
    "Use the Reset button to clear all the answers and randomize the order of the questions and options."
    ]
   [:div
    [primary-button state/clear-state! "Reset"]
    ]
   ]
  )

(defn page-container []
  [:div {:class "flex flex-col items-center text-center"}
   [:div {:class "flex flex-col items-center max-w-screen-md mt-12 px-4 sm:px-6 gap-20"}
    [header]
    [questions]
    [render-results]
    ]
   ]
  )
