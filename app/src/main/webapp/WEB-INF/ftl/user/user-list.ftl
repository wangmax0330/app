 <#setting number_format="#">
 
 <!--begin--> 
  <script type="text/javascript" src="${rc.contextPath}/res/js/user/user_list.js"></script> 
  <div id="simpledatatable_filter" class="dataTables_filter"> 
   <label> 
   	<input class="form-control input-sm" type="search" aria-controls="simpledatatable" /> 
   </label> 
  </div> 
  <table class="table table-bordered table-hover"> 
   <thead> 
    <tr> 
     <th style="width: 5px;"> ID </th> 
     <th style="width: 10px;"> 昵称 </th> 
     <th style="width: 10px;"> 手机 </th> 
     <th style="width: 10px;"> P城市 </th> 
     <th style="width: 10px;"> 积分 </th> 
     <th style="width: 10px;"> 机器码 </th> 
     <th style="width: 10px;"> IP </th> 
     <th style="width: 10px;"> 操作 </th> 
     <th style="width: 10px;"> </th> 
    </tr> 
   </thead> 
   
   <tbody id="user_list_tbody"> 
   
   </tbody> 
   
   
  </table> 
  
  <!--- page -->
  <div class="row DTTTFooter" id="user-list-pagination"> 
  
  </div>
  <!--- page end -->
 <!--end-->  
 <#include "./user-list-tmpl.ftl">