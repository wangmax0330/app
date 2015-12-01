// -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --KindEditor 插件执行完毕之后
//  大小的是全局变量
// $ 是全局对象
var $editor;
KindEditor.ready(function(K) {
    $editor = K.create('textarea[name="content"]', {
        allowFileManager: true,
        autoHeightMode: true,
        afterCreate: function() {
            this.loadPlugin('autoheight');
        }
    });
    //-----------------初始化清空内容
    $editor.html('');
});
