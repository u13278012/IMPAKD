/*'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/propertyDetails', {
    templateUrl: 'propertyDetails/propertyDetails.html',
    controller: 'PropertyDetailsCtrl'
  });
}])

//.controller('PropertyDetailsCtrl', [function() {
.controller('PropertyDetailsCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {


}]);*/

var app = angular.module('myApp', []);
app.controller('PropertyDetailsCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {
//app.controller('PropertyDetailsCtrl', function($scope) {

   
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
                url: 'http://localhost:8080/BackEnd/rs/property/getPropertyDetails',
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

    $scope.show = function () {
     
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