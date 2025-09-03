val range = 2 to 100
for (i <- range if i%2 !=0; if i%3 !=0; if i%5 !=0) yield i * i
for (i <- range if i%2 !=0; j <- range if j%2==0) yield(i, j)

range.withFilter(i => i % 2 != 0).withFilter(i => i % 3 != 0).withFilter(i => i % 5 != 0).map(i => i * i)
range.withFilter(i => i % 2 != 0).flatMap(i => range.withFilter(j => j % 2 == 0).map(j => (i, j)))


