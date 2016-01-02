<!doctype html>
<html>
<head>
</head>
<body>
<script type="text/javascript" src="${rc.contextPath}/res/plugin/blog/js/blog-list.js"></script>
                <h2 class="sub-header">Section title</h2>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>博客标题</th>
                                <th>发布状态</th>
                                <th>创建时间</th>
                                <th>浏览次数</th>
                                <th>最近修改时间</th>
                                <th>历史修改次数</th>
                                <th>版本号</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="blog_list_tbody">
                           
                           
                           
                        </tbody>
                    </table>
                </div>
                <nav>
                    <ul class="pager">
                        <div class="pagination" id="blog_list_pagination">
                           
                        </div>
                    </ul>
                </nav>
<#include "./blog_list_tmpl.ftl">
</body>