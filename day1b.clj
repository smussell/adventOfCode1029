
(defn calc [mass] 
  (- 
    (Math/floor (/ mass 3)) 
    2))

(defn calcr [mass] 
  (loop [m mass tot 0] 
    (let [cm (calc m)]
      (if (<= cm 0) 
        tot
        (recur cm (+ tot cm))))))
  
(reduce + (map calcr masses))
