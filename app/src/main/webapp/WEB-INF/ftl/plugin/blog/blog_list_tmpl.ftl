<#setting number_format="#">
<#import "../../res/macro.ftl" as macro>
<script id="_tpl_blog_list_tbody" type="text/x-jquery-tmpl"> 
{{each rows}} 
	 <tr>
        <td>
            <input type="checkbox">
        </td>
        <td>@{title}</td>
        <td>@{author.userName}</td>
        <td>@{createTime}</td>
        <td>
        	<a href="${rc.contextPath}/d/blog/editBlog/@{id}?u=${u!''}"><img  src="${rc.contextPath}/assets/images/icn_edit.png" /></a>
            <a onclick="alert("111");"><img  src="${rc.contextPath}/assets/images/icn_trash.png" /></a>
        </td>
    </tr>
{{/each}} 
</script>

<script id="_tpl_blog_pagination" type="text/x-jquery-tmpl">
	 <ul class="fr">
	    <li {{if hasPrevious5Page}}onclick="address.addressListing(@{previousPage})"{{else}}class="disabled"{{/if}}><a href="javascript:void(0);">&lt;&lt;</a></li>
	    {{each(i,page) pages}}
	    <li {{if page==currPage}}class="active"{{else}}onclick="address.addressListing(@{page})"{{/if}} ><a href="javascript:void(0);">@{page}</a></li>
	    {{/each}}
	    <li {{if hasNext5Page}}onclick="address.addressListing(@{nextPage})"{{else}}class="disabled"{{/if}}><a href="javascript:void(0);">&gt;&gt;</a></li>
	    <li class="disabled"><a href="#">总数：@{records}</a></li>
    </ul>
</script>