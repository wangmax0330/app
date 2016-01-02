<#if dateList??>
    <#list dateList as date>
        <li><a href="${rc.contextPath}/web/blog_index?month=${date.createTime!''}">${date.createTime!''}(${date.num!''})</a></li>
    </#list>
</#if>