(ns an-offer-you-cant-refuse.core)

(def prices {:apple 20 :orange 50 :watermelons 80})

(defmulti compute-price (fn [what howmany] what))

(defmethod compute-price :apple [what howmany]
  (+ (* (quot howmany 2) (:apple prices)  )
     (* (mod howmany 2) (:apple prices))
     ))




