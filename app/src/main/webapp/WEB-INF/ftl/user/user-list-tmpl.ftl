<#setting number_format="#">
<#import "../res/macro.ftl" as macro>
<script id="_tpl_user_list_tbody" type="text/x-jquery-tmpl"> 
{{each rows}} 
	  <tr>
        <td>
          @{id}
        </td>
        <td>
           @{nickName}
        </td>
        <td>
           @{age}
        </td>
        <td>
            SEO
        </td>
        <td>
            Napping
        </td>
        <td>
            Sergey-Azovskiy.jpg
        </td>
         <td>
            Sergey-Azovskiy.jpg
        </td>
         <td>
        	<a class=" " onclick="tk.load('/d/a-admin/userAddAmount/1');" href="#user-add-amount!uid=1" c-id="1" style="cursor: pointer">添加</a>
        </td>
    </tr>
{{/each}} 
</script>

<script id="_tpl_user_pagination" type="text/x-jquery-tmpl">
	<div class="col-sm-6">
		<div id="simpledatatable_info" class="dataTables_info" role="alert" aria-live="polite" aria-relevant="all">Showing 1 to 5 of 25 entries</div>
	</div>
	
	<div>
		<ul class="pagination">
	    <li {{if hasPrevious5Page}}onclick="shopList.shopListing(@{previousPage})"{{else}}class="disabled"{{/if}}><a href="javascript:void(0);">&lt;&lt;</a></li>
	    {{each(i,page) pages}}
	    <li {{if page==currPage}}class="active"{{else}}onclick="shopList.shopListing(@{page})"{{/if}} ><a href="javascript:void(0);">@{page}</a></li>
	    {{/each}}
	    <li {{if hasNext5Page}}onclick="shopList.shopListing(@{nextPage})"{{else}}class="disabled"{{/if}}><a href="javascript:void(0);">&gt;&gt;</a></li>
	    <li class="disabled"><a>总数：@{records}</a></li>
	</div>

</script>

