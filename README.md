# text-utils

A clojure library with utilities for working with text


Provides a function to convert text into a list of lines, each line being a list of the words that were in that line in the original text.

(to-lines-of-tokens "one two \n three four") produces as result: '(("one" "two") ("three" "four"))

(get-token-at 1 1 '(("a" "b") ("c" "d"))) produces as result: "d"