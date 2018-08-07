(ns an-offer-you-cant-refuse.core-test
  (:require
            [an-offer-you-cant-refuse.core :refer :all]
            [expectations :refer :all]))

(expect 0 (compute-price :apple 0)) ; 0 apples are for free
(expect 20 (compute-price :apple 1)) ; 1 apple goes full price
(expect 20 (compute-price :apple 2)) ; 1 apple, 1 goes for free!
; for the first two apples the special offers kicks in
; for the third apple, full price
(expect 40 (compute-price :apple 3))
; one full price, one free, one full, one free
(expect 40 (compute-price :apple 4))


; no oranges are cheap
(expect 0 (compute-price :orange 0))

; buy one pay one: no special offers for oranges
(expect 50 (compute-price :orange 1))
(expect 100 (compute-price :orange 2))
(expect 150 (compute-price :orange 3))

; no watermelons are also cheap
(expect 0 (compute-price :watermelon 0))
; one goes full price...
(expect 80 (compute-price :watermelon 1))
; ... and so do two
(expect 160 (compute-price :watermelon 2))
; here the special offer kicks in: buy 3, pay 2
(expect 160 (compute-price :watermelon 3))
; for the first 3 items the offer applies, the 4th watermelon goes full price
(expect 240 (compute-price :watermelon 4))
; for the first 3 items the offer applies, the remaning 2 go full price
(expect 320 (compute-price :watermelon 5))

; an empty basket is free
(expect 0 (total-price {:apple 0 :orange 0 :watermelon 0}))

; example of total basket price calculation
(expect (+ 40 150 320) (total-price {:apple 4 :orange 3 :watermelon 5}))
