<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Laptop</title>
</head>
<body>

    <h2>Edit Laptop Details</h2>
    
    <form action="/update" method="post">
    <input type="hidden" name="id" value="${laptop.id}">
    <label for="brand">Brand:</label>
    <input type="text" name="brand" value="${laptop.brand}" >

    <label for="model">Model:</label>
    <input type="text" name="model" value="${laptop.model}" >

   

    <button type="submit">Update</button>
</form>

</body>
</html>
