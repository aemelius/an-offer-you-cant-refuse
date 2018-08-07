(ns an-offer-you-cant-refuse.core-test
  (:require
            [an-offer-you-cant-refuse.core :refer :all]
            [expectations :refer :all]))

(expect 40 (compute-price :apple 4))
(expect 20 (compute-price :apple 1))
(expect 20 (compute-price :apple 2))
(expect 40 (compute-price :apple 3))

(expect 50 (compute-price :orange 1))
(expect 100 (compute-price :orange 2))
(expect 150 (compute-price :orange 3))


(expect 80 (compute-price :watermelon 1))
(expect 160 (compute-price :watermelon 2))
(expect 160 (compute-price :watermelon 3))
(expect 240 (compute-price :watermelon 4))


