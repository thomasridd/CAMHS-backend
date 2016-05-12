library("jsonlite")

input_file <- "names.csv"
output_file <- "names.json"

# Read data
data <- read.csv("names.csv", stringsAsFactors = F)

json <- toJSON(data)

write(json, output_file)

