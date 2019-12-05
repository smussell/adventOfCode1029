

(defn op [oper p1 p2 out list]
    (assoc list out (oper (get list p1) (get list p2))))

(defn ops [n] 
  (get {
    1 (partial op +)
    2 (partial op *)
  } n))

(defn exec [input]
  (loop [opInd 0 instrs input]
    (let [op (get instrs opInd)]
      (if (= op 99) 
        instrs
        (let [args (conj (subvec instrs (+ opInd 1) (+ opInd 4)) instrs)] 
          (recur (+ opInd 4) (apply (ops op) args)))))))


(defn brute [n] 
  (for [i (range 100) 
        j (range 100)
        :let [instrs (assoc prog 1 i 2 j)
              out (exec instrs)] 
        :when (= (first out) n)] 
    out))
