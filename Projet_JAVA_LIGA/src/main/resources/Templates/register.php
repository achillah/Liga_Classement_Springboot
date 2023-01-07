<?php

// Connect to the MySQL database server
$host = "localhost";
$username = "root";
$password = "";
$dbname = "ligadatabase";

$conn = mysqli_connect($host, $username, $password, $dbname);
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Get the form data
$username = $_POST["username"];
$password = $_POST["password"];

// Insert the data into the database
$sql = "INSERT INTO users (username, password) VALUES (?, ?)";
$stmt = mysqli_prepare($conn, $sql);
mysqli_stmt_bind_param($stmt, "ss", $username, $password);
mysqli_stmt_execute($stmt);
if (mysqli_stmt_affected_rows($stmt) > 0) {
    echo "Your data was stored successfully!";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
mysqli_close($conn);

?>