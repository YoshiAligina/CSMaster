#Here I am loading and observing my data, just in case.

setwd("C:/Users/yoshi/OneDrive/Documents/RegressionHW")
hw1 <- read.table("hw1.txt", header = TRUE)
hw1

#This is both part a and part b. Setting up a plot as well as creating a line with the mentioned specifications. 

plot(hw1$GDP, hw1$Satisfaction, 
     xlab = "GDP per capita (In Thousands)", 
     ylab = "Satisfaction",
     main = "Satisfaction vs GDP")

abline(5.77, 0.0674, col = "blue")

#This is part C, calculating the satisfaction score of Frace, 7.617.

france_gdp <- 27.4
france_satisfaction <- 5.77 + 0.0674 * france_gdp
cat("Expected satisfaction for France:", france_satisfaction)

#This is me repeating the graph for d, but with a tringle in place to represent the score of France.

plot(hw1$GDP, hw1$Satisfaction, 
     xlab = "GDP per capita (In Thousands)", 
     ylab = "Satisfaction",
     main = "Satisfaction vs GDP")

abline(5.77, 0.0674, col = "blue")
points(france_gdp, france_satisfaction, col = "red", pch = 19)


#Here I am calculating the satisfaction of Greece and Turkey as I did in part C. I then added those to the prior plot once more for part E. 

greece_gdp <- 21.5
turkey_gdp <- 10.1

greece_satisfaction <- 5.77 + 0.0674 * greece_gdp
turkey_satisfaction <- 5.77 + 0.0674 * turkey_gdp

plot(hw1$GDP, hw1$Satisfaction, 
     xlab = "GDP per capita (In Thousands)", 
     ylab = "Satisfaction",
     main = "Satisfaction vs GDP")

abline(5.77, 0.0674, col = "blue")
points(france_gdp, france_satisfaction, col = "red", pch = 19)
points(greece_gdp, greece_satisfaction, col = "gray", pch = 19)
points(turkey_gdp, turkey_satisfaction, col = "pink", pch = 19)

legend("bottomright", 
       legend = c("Original Data", "France", "Greece", "Turkey"),
       col = c("black", "red", "gray", "pink"),
       pch = c(19, 19, 19, 19))



