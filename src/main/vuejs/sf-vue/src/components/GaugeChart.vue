<template>
  <div>
    <highcharts :options="options" :style="{width:this.width+'px', height:this.height+'px'}"></highcharts>
  </div>
</template>

<script>
  /* eslint-disable */
  export default {
    props: ['title', 'minValue', 'maxValue', 'value', 'width', 'height'],
    data () {
      return {
        options: {
          chart: {
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
          },
          title: {
            text: this.title
          },
          pane: {
            startAngle: -150,
            endAngle: 150,
            background: [{
              backgroundColor: {
                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                stops: [
                  [0, '#FFF'],
                  [1, '#333']
                ]
              },
              borderWidth: 0,
              outerRadius: '109%'
            }, {
              backgroundColor: {
                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                stops: [
                  [0, '#333'],
                  [1, '#FFF']
                ]
              },
              borderWidth: 1,
              outerRadius: '107%'
            }, {
              // default background
            }, {
              backgroundColor: '#DDD',
              borderWidth: 0,
              outerRadius: '105%',
              innerRadius: '103%'
            }]
          },

          // the value axis
          yAxis: {
            min: this.minValue,
            max: this.maxValue,

            minorTickInterval: 'auto',
            minorTickWidth: 1,
            minorTickLength: 10,
            minorTickPosition: 'inside',
            minorTickColor: '#666',

            tickPixelInterval: 20,
            tickWidth: 1,
            tickPosition: 'inside',
            tickLength: 10,
            tickColor: '#666',
            labels: {
              step: 2,
              rotation: 'auto'
            },
            title: {
              text: '%'
            },
            plotBands: [{
              from: 0,
              to: 70,
              color: '#DF5353' // green
            }, {
              from: 70,
              to: 90,
              color: '#DDDF0D' // yellow
            }, {
              from: 90,
              to: 100,
              color: '#55BF3B' // red
            }]
          },
          series: [{
            name: 'OEE',
            data: [this.value*1],
            tooltip: {
              valueSuffix: ' %'
            }
          }]
        }
      }
    }
  }
</script>

<style>

</style>
