


<body style="padding:0">
<div style="padding:10px;clear: both;">
    <div id="psLine" style="height:600px;"></div>
</div>
</body>
<script type="text/javascript" src="js/echarts-all.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>




<script type="text/javascript">
    //å¾è¡¨
    var psLineChar = echarts.init(document.getElementById('psLine'));

    //æ¥è¯¢
    function loadDrugs() {
        psLineChar.clear();
        psLineChar.showLoading({text: '请稍等，正在加载...'});
        $.getJSON('analysis/removecauses.html', function (data) {
            if (data.success) {
                psLineChar.setOption(data.data, true);
                psLineChar.hideLoading();
            } else {
                alert('提示', data.msg);
            }
        });
    }
    //è½½å¥å¾è¡¨
    loadDrugs();
</script>