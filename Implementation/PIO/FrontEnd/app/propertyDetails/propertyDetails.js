/*'use strict';*/
var app = angular.module('myApp', []);
app.controller('PropertyDetailsCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {

     
   
   $scope.getProfileID = function() 
    {

            var session  = localStorage.getItem("session");
            var propertyid  = localStorage.getItem("property");
            var encodedString = 'profileID=' +
            encodeURIComponent(session)+
            '&propertyid=' +
            encodeURIComponent(propertyid);
            //51029
           
        
            $http({
                method: 'POST',
                url: 'http://localhost:51029/BackEnd/rs/property/getPropertyDetails',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var x = x2js.xml_str2json(response);
                    $scope.propertyresults = x;
                    console.log(x);
                   

                }).
                error(function(response)
                {
                     alert(response);

                });

        };
   $scope.getROI = function() 
   { 
     var d = new Date();
     var currentYear = d.getFullYear();
     $scope.Year = [];
     for(var x = 0; x < 10 ;x++){
      $scope.Year[x] = currentYear; 
      currentYear =currentYear+1;
     // alert($scope.Year[x]);
     }
    $scope.ROI = [0,25,32,45,30,33,37,42,44,51]; 
  };
    $scope.show = function () {
     $scope.getROI();
         var session  = localStorage.getItem("session");
             if (typeof(Storage) === "undefined") {
         alert("You're not logged in");
         //go to login
           
        }


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
				{ label: $scope.Year[0], y: $scope.ROI[0] },
				{ label: $scope.Year[1], y: $scope.ROI[1]},
				{ label: $scope.Year[2], y: $scope.ROI[2] },
				{ label: $scope.Year[3], y: $scope.ROI[3] },
				{ label: $scope.Year[4], y: $scope.ROI[4] },
				{ label: $scope.Year[5], y: $scope.ROI[5] },
				{ label: $scope.Year[6], y: $scope.ROI[6] },
				{ label: $scope.Year[7], y: $scope.ROI[7] },
				{ label: $scope.Year[8], y: $scope.ROI[8]},
				{ label: $scope.Year[9], y: $scope.ROI[9] }
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
 // document.getElementById("viewGraphPD").style.color ="white"; 
 //document.getElementById("viewGraphPD").style.backgroundColor ="teal";
             
//document.getElementById("linkTOProperty").style.color ="teal";
             
};
    $scope.model = {
			propertyName: 'City Properties',
			tax: '21%',
			inflation: '5.5%',
			anualMantainance: '6000.00',
                        anualCostIncrease: '10%',
				
                        interestRate: '10%',
			depositeASPercentage: '21%',
		        propertyValue: 'R500000.00',
                        numberOfYears: '30',
                
			 occupancyRate: '11%',
		         agentCommission: 'R 17000.00',
		         rentalAmount: '5000.00'
                
                
				};
                                
   $scope.back = function()
   {
       localStorage.removeItem("property");
       window.location = "../home/home.html";
   }
                                
}]);