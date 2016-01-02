<#setting number_format="#">
    <style type="text/css">
    .blog_tag {
        border: 1px solid #ddd;
        height: auto;
        margin: 5px auto 0;
        padding: 0 5px 5px;
    }
    
    .blog_tag i {
        background: rgba(0, 0, 0, 0) url("${rc.contextPath}/dev-lib/assets/images/close_user.png") no-repeat scroll 0 0;
        cursor: pointer;
        display: inline-block;
        height: 7px;
        margin-left: 5px;
        width: 7px;
    }
    
    .blog_tag span.z {
        background: #d4e6fe none repeat scroll 0 0;
        border: 1px solid #ddd;
        border-radius: 3px;
        color: #333;
        display: inline-block;
        margin-right: 5px;
        margin-top: 5px;
        padding: 2px 5px;
    }
    
    .blog_tag span.new {
        background: #99CC66 none repeat scroll 0 0;
        border: 1px solid #ddd;
        border-radius: 3px;
        color: #333;
        display: inline-block;
        margin-right: 5px;
        margin-top: 5px;
        padding: 2px 5px;
    }
    </style>
    <div class="container-fluid">
        <div class="alert alert-info">
            <a href="#" class="close" data-dismiss="alert">
            &times;
             </a>
            <strong>标签！</strong>尽量填写符合规范的标签,不要重复
        </div>
        <div class="grounp_add blog_tag">
            <input type="text" value="" placeholder="添加新的标签" id="add_new_tag">
            <#if tags??>
                <#list tags as tag>
                    <span class="new" did="${tag.value!''}">
                            ${tag.value!''}
                            <i class="del-dataSelector"></i>
                      </span>
                </#list>
            </#if>
        </div>
    </div>
<script type="text/javascript" src="${rc.contextPath}/res/plugin/blog/js/blog_tag_edit.js"></script>