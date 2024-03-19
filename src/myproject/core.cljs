(ns myproject.core
    (:require
      [myproject.views :as views]
      [reagent.dom :as d]))

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [views/page-container] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
