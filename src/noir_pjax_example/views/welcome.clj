(ns noir-pjax-example.views.welcome
  (:require [noir-pjax-example.views.common :as common]
            [noir.content.getting-started])
  (:require noir.request)
  (:use [noir.core :only [defpage]]
        hiccup.core
        hiccup.page-helpers))

(defpage "/" []
  (if (nil? (((noir.request/ring-request) :headers) "x-pjax"))
    (common/layout
      [:p "Welcome to noir-pjax-example /"]
      [:a {:href "/"} "foo 1"])
    (str
      "<p>Welcome to noir-pjax-example /</p>"
      "<a class=foo href=\"/foo\">foo 2</a>")))

(defpage "/foo" []
  (if (nil? (((noir.request/ring-request) :headers) "x-pjax"))
    (common/layout
      [:p "Welcome to noir-pjax-example /foo"]
      [:a {:href "/"} "home 4"])
    (str
      "<p>Welcome to noir-pjax-example /foo</p>"
      "<a class=foo href=\"/\">home 3</a>")))

