
<body>

<%-- <div class="container">          
  <img src="<c:url value="/shoppingcartfrontend/src/main/webapp/resources/lib/images/image.jpg" />"> 
</div> - --%>
<!-- <div class="model-body row"> --><!-- 
<div class ="col-md-1"> -->
<!-- <div class="row">-->
<!-- <div class ="panel panel-body"> -->
<div class="container">
 <div class="col-md-6"> 
 <center><lable  style="font-size: 20px; font-family: serif background-color : black; color: red"/>${error}</lable></center>
      <lable  style="font-size: 20px; font-family: serif background-color : black; color: green"/>  ${successmsg} </lable>
        <lable  style="font-size: 20px; font-family: serif background-color : black; color: red"/> ${invalidmsg}</lable>
        
 <form class="form-horizontal well" style="width:400px;" role="form" action="validate" method="post" >
 <h1 class="well center"><center>LOGIN</center></h1>
    <div class="form-group">
      <label class="control-label col-sm-3"  for="email">Email-ID:</label>
      <div class="col-sm-8">
        <input type="email" class="form-control" name="email"  placeholder="Enter Email-Id" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="pwd">Password:</label>
      <div class="col-sm-8">
        <input type="password" class="form-control" name="pwd"  placeholder="Enter password" required>
      </div>
    </div>
  <!--   <div class="form-group">
      <div class="col-sm-offset-3 col-sm-7">
        <div class="checkbox">
          <label><input type="checkbox"> Remember me</label>
  
        </div>
      </div>
    </div> -->
    <br>
    <div class="form-group">
      <div class="col-sm-offset-4 col-sm-10">
        <button type="submit" class="btn btn-default">Login</button>
    
      
      </div>
    </div>
  </form>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
