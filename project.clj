(defproject an-offer-you-cant-refuse "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [expectations "1.4.52"]
                 [org.clojure/tools.cli "0.2.4"]]
  :plugins [[lein-cljfmt "0.6.0"]]
  :main an-offer-you-cant-refuse.core
  :aot [an-offer-you-cant-refuse.core])
