<#if domainList??>
    <#list domainList as domain>
        <div class="blog-post">
            <h4 class="blog-post-title">${domain.title}</h4>
            <p class="blog-post-meta">分类 <a href="#">${domain.tags!''}</a></p>
            ${domain.simpleContent!''}
            <p>发布于 ${domain.createTime?string("yyyy-MM-dd HH:mm:ss")}， <a href="viewblog/${domain.id}"> 阅读全文...</a></p>
        </div>
    </#list>
</#if>


<script id="_tpl_blog_pagination" type="text/x-jquery-tmpl">
	    <li <#if hasPrevious5Page>onclick="web.webListing(${previousPage})"<#else>class="disabled"</#if>><a href="javascript:void(0);">&lt;&lt;</a></li>
	    <#if pages??>
    		<#list pages as page>
	    		<li <#if page==currPage>class="active"<#else>onclick="web.webListing(${page})"</#if>><a href="javascript:void(0);">${page}</a></li>
			</#list>
		</#if>
	    <li <#if hasNext5Page>onclick="web.webListing(${nextPage})"<#else>class="disabled"</#if>><a href="javascript:void(0);">&gt;&gt;</a></li>
	    <li class="disabled"><a href="#">总数：${records}</a></li>
</script>
