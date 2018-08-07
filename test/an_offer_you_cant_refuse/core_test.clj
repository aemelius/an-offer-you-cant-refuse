(ns an-offer-you-cant-refuse.core-test
  (:require
            [an-offer-you-cant-refuse.core :refer :all]
            [expectations :refer :all]))



(expect 40 (compute-price :apple 4))

(expect 20 (compute-price :apple 1))
(expect 20 (compute-price :apple 2))
(expect 40 (compute-price :apple 3))
