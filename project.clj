(defproject miscellany "0.0.3"
  :description "A motley assortment of Clojure bits and pieces"
  :url "http://github.com/rsslldnphy/miscellany"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :signing {:gpg-key "DF49164D"}
  :scm {:name "git"
        :url "https://github.com/rsslldnphy/miscellany"}
  :profiles {:dev {:dependencies [[expectations "2.0.9"]]
                   :plugins [[lein-autoexpect "1.0"]
                             [lein-expectations "0.0.8"]]}})
