(ns website1.views.welcome
  (:require [website1.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to website1"]))

(defpage "/my-page" []
  (common/site-layout
   [:h1 "Welcome to my site!"]
   [:p "Hope you like it."]))

;; defpage is all about destructuring stuff, more info
;; http://blog.jayfields.com/2010/07/clojure-destructuring.html
(defpage "/todos" {}
  (let [items (all-todos)]
    (layout
     [:h1 "Todo List!"]
     (todos-list items))))

(defpage [:post "/todos"] {:keys [title due]}
  (if-let [todo-id (add-todo title due)]
    (response/json {:id todo-id
                    :title title
                    :due-date due-date})
    []))

(defpage "/todo/remove/:id" {todo-id :id}
  (if (remove-todo todo-id)
    (response/json {id todo-id})
    (response/empty)))