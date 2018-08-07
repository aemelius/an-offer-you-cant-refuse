(ns an-offer-you-cant-refuse.core)

(def prices {:apple 20 :orange 50 :watermelon 80})

(defmulti compute-price (fn [what howmany] what))

(defmethod compute-price :apple [what howmany]
  (+ (* (quot howmany 2) (:apple prices))
     (* (mod howmany 2) (:apple prices))
     ))

(defmethod compute-price :watermelon [what howmany]
  (+ (* (quot howmany 3) (* (:watermelon prices) 2)  ) ;; groups of 3 cost as 2
     (* (mod howmany 3) (:watermelon prices)) ;; the remaining are full price
     ))


(defmethod compute-price :default [what howmany]
  (* howmany (get prices what)))




