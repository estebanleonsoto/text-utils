(ns text-tokenization.lines-of-tokens
  (:require [clojure.string :as s]))

(defn- not-blank? [text]
  (not (s/blank? text)))

(defn to-lines-of-tokens [text]
  (->> text
       (s/split-lines)
       (map #(s/split % #" "))
       (map #(filter not-blank? %))
       (filter #(not (empty? %)))))

(defn get-token-at [line word data]
  (try (nth (nth data line) word)
       (catch IndexOutOfBoundsException e "")))

