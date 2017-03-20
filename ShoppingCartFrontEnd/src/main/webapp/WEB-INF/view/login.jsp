
<body>
	<div class="container">
		<div class="col-sm-offset-4 col-sm-11" style="height:70%;width: 95.8%; margin-left:23;padding-bottom:150px; background-image: url('resources/lib/images/baground.jpg');">
			
			<lable style="font-size: 20px; font-family: serif background-color : black; color: green" />
			${successmsg}
			</lable>
     <lable  style="font-size: 20px; font-family: serif background-color : black; color: red"/> ${invalidmsg}</lable>
    
 <form class="form-horizontal"  role="form" action="validate" method="post" >
 <div class="row" style="padding-top:100px;">

 	
 	<div class="col-sm-7">
 
   <br>
   <div style="width:90%;padding-top:40px; height:40%;">
 			<center><lable  style="font-size: 20px; font-family: serif background-color : black; color: red"/>${error}</lable></center>
    		
    			<div class="form-group">
      				<label class="control-label col-sm-2"  for="email"></label>
      					<div class="col-sm-8">
        					<input type="email" style="box-shadow:0px 1px 2px 0px gray;"class="form-control" name="email"  placeholder="Enter Email-Id" required>
      					</div>
   				 </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="pwd"></label>
			      <div class="col-sm-8">
			        <input type="password" style="box-shadow:0px 1px 2px 0px gray;" class="form-control" name="pwd"  placeholder="Enter password" required>
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
			      <div class="col-sm-offset-2 col-sm-8">
			        <button type="submit" style="font-family:Bell MT; box-shadow:0px 1px 2px 0px gray;"  class="btn btn-default btn-block"><b>Login</b></button>
			      </div>
			    </div>
			 	</div>
 	</div>
 </div>
  </form>
</div>
	</div>
</body>
