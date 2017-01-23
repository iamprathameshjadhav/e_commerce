
<body>
<div class="container">
 <div class="col-sm-5"> 
 
      <lable  style="font-size: 20px; font-family: serif background-color : black; color: green"/>  ${successmsg} </lable>
        <lable  style="font-size: 20px; font-family: serif background-color : black; color: red"/> ${invalidmsg}</lable>
    
 <form class="form-horizontal well"  style="width:380px; height:340px;  margin-top:60px;"  role="form" action="validate" method="post" >
 <h1 class="well center" style=" font-family: Maiandra GD;"><center>LOGIN</center></h1>
 <center><lable  style="font-size: 20px; font-family: serif background-color : black; color: red"/>${error}</lable></center>
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
      <div class="col-sm-offset-1 col-sm-10">
        <button type="submit"  class="btn btn-success btn-block"  style="margin-bottom:300px;">Login</button>
      
      </div>
    </div>
  </form>
</div>
</div>
</body>
