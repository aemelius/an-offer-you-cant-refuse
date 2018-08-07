(ns an-offer-you-cant-refuse.core)

(def prices {:apple 20 :orange 50 :watermelon 80})

(defmulti compute-price (fn [what howmany] what))

(defn x-for-the-price-of-y [x y what howmany]
  (+ (* (quot howmany x) (* (get prices what) y))
     (* (mod howmany x) (get prices what))
     ))

(defmethod compute-price :apple [what howmany]
  (x-for-the-price-of-y 2 1 :apple howmany)
  )

(defmethod compute-price :watermelon [what howmany]
  (x-for-the-price-of-y 3 2 :watermelon howmany)
  )

(defmethod compute-price :default [what howmany]
  (* howmany (get prices what)))


(defn total-price [basket]
  (reduce +
          (map
            (fn [item] (compute-price (first item) (second item)))
            basket)
          ))


