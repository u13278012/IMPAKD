/* jshint ignore:start */
import Ember from 'ember';

export default Ember.Controller.extend({
    
    actions: {
         addTask: function () {
            
		var chart = new CanvasJS.Chart("chartContainer",
		{
			title:{
				text: "ROI IN YEARS"
			},   
                        animationEnabled: true,  
			axisY:{ 
				title: "ROI %",
				includeZero: false                    
			},
			axisX: {
				title: "Years",
				interval: 1
			},
			toolTip: {
				shared: true,
				content: function(e){
					var body = new String;
					var head ;
					for (var i = 0; i < e.entries.length; i++){
						var  str = "<span style= 'color:"+e.entries[i].dataSeries.color + "'> " + e.entries[i].dataSeries.name + "</span>: <strong>"+  e.entries[i].dataPoint.y + "</strong>'' <br/>" ; 
						body = body.concat(str);
					}
					head = "<span style = 'color:DodgerBlue; '><strong>"+ (e.entries[0].dataPoint.label) + "</strong></span><br/>";

					return (head.concat(body));
				}
			},
			legend: {
				horizontalAlign :"center"
			},
			data: [
			{        
				type: "spline",
				showInLegend: true,
				name: "ROI%",
				dataPoints: [
				{ label: 2016, y: 0 },
				{ label: 2017, y: 25},
				{ label: 2018, y: 20 },
				{ label: 2019, y: 40 },
				{ label: 2020, y: 50 },
				{ label: 2021, y: 66 },
				{ label: 2022, y: 70 },
				{ label: 2023, y: 64 },
				{ label: 2024, y: 69},
				{ label: 2025, y: 72 }
				]
			} 
			],
          legend :{
            cursor:"pointer",
            itemclick : function(e) {
              if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
				e.dataSeries.visible = false;
              }
              else{
				e.dataSeries.visible = true;
              }
              chart.render();
            }
          }
          
		});

chart.render();
  document.getElementById("viewGraphPD").style.color ="white"; 
 document.getElementById("viewGraphPD").style.backgroundColor ="teal";
             
document.getElementById("linkTOProperty").style.color ="teal";
             
}
  }
    
});
/* jshint ignore:end */