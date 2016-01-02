<#if tagList??>
    <#list tagList as tag>
        <li><a href="${rc.contextPath}/web/blog_index?tag=${tag.name}">${tag.name}(${tag.num})</a></li>
    </#list>
</#if>