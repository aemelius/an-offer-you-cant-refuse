(ns an-offer-you-cant-refuse.core
  (:gen-class)
  (:import (java.text SimpleDateFormat)))
(require '[clojure.tools.cli :refer [cli]])

(def prices {:apple 20 :orange 50 :watermelon 80})



(defn create-date [string-rep] (.parse (SimpleDateFormat. "dd.MM.yyyy")
                                       string-rep
                                       ))

(def promotion-valid-until {:apple "12.08.2018" :watermelon "24.12.2018"} )

(defn promotion-valid? [what date] (and (what promotion-valid-until) (= -1  (compare
                                           (create-date date)
                                           (create-date
                                            (get promotion-valid-until what))))))


(defmulti compute-price (fn [what howmany date] [what (promotion-valid? what date) ] ))

(defn x-for-the-price-of-y [x y what howmany]
  (+ (* (quot howmany x) (* (get prices what) y))
     (* (mod howmany x) (get prices what))))

(defn default-price [what howmany]
  (* howmany (get prices what)))

(defmethod compute-price [ :apple true ] [what howmany date]
  (x-for-the-price-of-y 2 1 :apple howmany)
  )

(defmethod compute-price [ :watermelon true ] [what howmany date]
  (x-for-the-price-of-y 3 2 :watermelon howmany))

; by default, no special offers are applied. This applies, e.g., to oranges
(defmethod compute-price :default [what howmany date]
  (default-price what howmany))

(defn total-price [basket date]
  (reduce +
          (map
           (fn [item] (compute-price (first item) (second item) date))
           basket)))

(defn -main [& args]
  (let [[opts args banner] (cli args
                                ["-h" "--help" "I need to know how many apples, oranges and watermelons are in your basket."
                                 :default false :flag true]
                                ["-a" "--apples" "How many apples are there in your basket?" :parse-fn #(Integer. %) :default 0]
                                ["-o" "--oranges" "How many oranges are there in your basket?" :parse-fn #(Integer. %) :default 0]
                                ["-w" "--watermelons" "How many watermelons are there in your basket?" :parse-fn #(Integer. %) :default 0])
        apples (:apples opts)
        oranges (:oranges opts)
        watermelons (:watermelons opts)]
    (if (:help opts)
      (println banner)
      (println (str "The total price for " apples " apples "
                    oranges " oranges and "
                    watermelons " watermelons is: "
                    (/ (total-price {:apple apples :orange oranges :watermelon watermelons}) 100.)
                    " pounds.")))))


