(ns website1.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "website1"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))

(defpartial site-layout [& content]
  (html5
   [:head
    [:title "my site"]]
   [:body
    [:div#wrapper
     content]]))

(defpartial todo-item {:keys [id title due]}
  [:li {:id id} ;; maps define HTML attributes
   [:h3 title]
   [:span.due due]] ;; add a class
  )

(defpartial todos-list [items]
  [:ul#todoItems ;; set the id attribute (to todoItems
   (map todo-item items)])

(all-todos [{:id "todo1"
              :title "Get milk"
              :due "today"}])