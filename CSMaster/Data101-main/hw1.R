c1 <- c("Y","o","S","H","I","T","A")
v1 <- c(1,2,3,4,5,6,7)
v2 <- c(14,12,10,8,6,4,2)

hw1 <- data.frame(c1,v1,v2)
hw1$v3 <- hw1$v1 + hw1$v2

minimum <- min(hw1$v3)
maximum <- max(hw1$v3)

cat("Minimum:", minimum,"\n")
cat("Maximum:", maximum,"\n")