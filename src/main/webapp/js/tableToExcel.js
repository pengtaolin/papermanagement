/**公用方法
 *  方法：exportToExcel(tableid,filename,sheetname)
 *  参数：tableid 表格ID,filename 文件名,sheet名
 *  功能：导出界面表格中的数据到Excel
 *  返回：
 *  Auther:king 
 *  Rem: 2017-6-7 add 
 */
function exportToExcel(tableid,filename,sheetname){  
    if(getExplorer()=='ie'){
        var curTbl = document.getElementById(tableid);  
        var oXL = new ActiveXObject("Excel.Application");  
        var oWB = oXL.Workbooks.Add();  
        var xlsheet = oWB.Worksheets(1);  
        var sel = document.body.createTextRange();  
        sel.moveToElementText(curTbl);  
        sel.select();  
        sel.execCommand("Copy");  
        xlsheet.Paste();  
        oXL.Visible = true;    
        try{  
            var fname = oXL.Application.GetSaveAsFilename(filename, "Excel Spreadsheets (*.xls), *.xls");  
        } catch (e){  
            print("Nested catch caught " + e);  
        } finally {  
            oWB.SaveAs(fname);  
            oWB.Close(savechanges = false);  
            oXL.Quit();  
            oXL = null;  
            idTmr = window.setInterval("Cleanup();", 1);  
        }  


    }else{  
        tableToExcel(tableid,filename,sheetname)  
    }  
} 


function Cleanup(){  
    window.clearInterval(idTmr);  
    CollectGarbage();  
} 




/**公用方法
 *  方法：tableToExcel(table,name,filename)
 *  参数：tableid 表格ID
 *  功能：将html的table转成Excel的data协议类型数据 table 是HTML DOM Document 对象 name 是sheet的名称
 *  返回：
 *  Auther:king 
 *  Rem: 2017-6-7 add 
 */
var tableToExcel = (function (){ 
    var uri = 'data:application/vnd.ms-excel;base64,',
    template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
    base64 = function (s) {
    return window.btoa(unescape(encodeURIComponent(s)));
    },
    format = function (s, c){
    return s.replace(/{(\w+)}/g, function (m, p) { return c[p]; }); 
    };
    return function (table,filename,sheetname){

//这里创建一个<a/>标记利用a标记的download属性来自定义Excel文件名,解决button按钮触发下载无法自定义Excel文件名的问题
    var a = $('<a id="dlink" style="display:none;"/>');
        $(document.body).append(a);
        if (!table.nodeType) table = document.getElementById(table);
        var ctx = { worksheet: sheetname || 'Worksheet', table: table.innerHTML }
        a.attr("href",uri + base64(format(template, ctx)));
        a.attr("download",filename);//这里是关键所在,当点击之后,设置a标签的属性,这样就可以更改excel文件的名字了
        document.getElementById("dlink").click();
    }
})();



/*<button type="button" class="btn btn-primary" onclick="tableToExcel('contentTable','学生论文课题汇总.xls','课题汇总')"></button>*/