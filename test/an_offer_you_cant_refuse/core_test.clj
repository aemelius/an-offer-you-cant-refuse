(ns an-offer-you-cant-refuse.core-test
  (:require
            [an-offer-you-cant-refuse.core :refer :all]
            [expectations :refer :all]))

(expect 0 (compute-price :apple 0))
(expect 20 (compute-price :apple 1))
(expect 20 (compute-price :apple 2))
(expect 40 (compute-price :apple 3))
(expect 40 (compute-price :apple 4))

(expect 0 (compute-price :orange 0))
(expect 50 (compute-price :orange 1))
(expect 100 (compute-price :orange 2))
(expect 150 (compute-price :orange 3))


(expect 0 (compute-price :watermelon 0))
(expect 80 (compute-price :watermelon 1))
(expect 160 (compute-price :watermelon 2))
(expect 160 (compute-price :watermelon 3))
(expect 240 (compute-price :watermelon 4))
(expect 320 (compute-price :watermelon 5))

(expect 0 (total-price {:apple 0 :orange 0 :watermelon 0}))
(expect (+ 40 150 320) (total-price {:apple 4 :orange 3 :watermelon 5}))



