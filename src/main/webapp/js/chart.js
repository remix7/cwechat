 $(document).ready(function() {
 
 'use strict'; 

           Morris.Area({
            element: 'hero-area',
            data: [{
                period: '2005',
                iphone: 2250
            }, {
                period: '2006',
                iphone: 4550
            }, {
                period: '2007',
                iphone: 7750
            }, {
                period: '2008',
                iphone: 5750
            }, {
                period: '2009',
                iphone: 10000
            }, {
                period: '2010',
                iphone: 9000
            }, {
                period: '2011',
                iphone: 8000
            }, {
                period: '2012',
                iphone: 7000
            }],
            xkey: 'period',
            ykeys: ['iphone'],
            labels: ['iPhone'],
            hideHover: 'auto',
            lineWidth: 2,
            pointSize: 10,
            lineColors: ['#72d0eb'],
           
            fillOpacity: 1.0,
            smooth: true
		//pointFillColors: ['#00ff00']
        });
      });