<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping Address</title>
</head>
<body>
<div class="col-md-4">
  <h2>Shipping Address</h2>
  <form>
    <div class="form-group">
      <label for="usr">Line 1:</label>
      <input type="text" class="form-control" name="address" placeholder="Line1" required>
    </div>
   <div class="form-group">
      <label for="usr">Line 2:</label>
      <input type="text" class="form-control" name="address" placeholder="Line2" required>
    </div>
    <div class="form-group">
      <label for="usr">City:</label>
      <input type="text" class="form-control" name="city" placeholder="City" required>
    </div>
    <div class="form-group">
      <label for="usr">Country:</label>
      <input type="text" class="form-control" name="country" placeholder="Country" required>
    </div>
    <div class="form-group">
      <label for="usr">Zip code:</label>
      <input type="text" class="form-control" name="number"placeholder="Zip Code" required>
    </div>
      <div class="container">
       <button type="button" class="btn btn-success">Save</button>
       <button type="button" class="btn btn-danger">Cancel</button>    
</div>
  </form>
</div>
</body>
</html>