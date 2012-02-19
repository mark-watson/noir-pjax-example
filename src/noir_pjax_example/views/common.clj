(ns noir-pjax-example.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]
        hiccup.core
        hiccup.page-helpers))

(defpartial layout [& content]
  (println "\n**** layout\n")
  (html5
    [:head [:title "noir-pjax-example"]
     (include-css "/css/reset.css")
     (include-js "/js/jquery.js")
     (include-js "/js/jquery.pjax.js")
     (include-js "/js/application.js")]
    [:body "<h1><b>Demo of pjax with Clojure and Noir</b></h1><br/><br/>"
     "<div id=\"wrapper\">"
     content
     "</div>"]))
