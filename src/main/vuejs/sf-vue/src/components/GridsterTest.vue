<template>
  <div id="content">
    <grid-layout
      :layout="layout"
      :col-num="12"
      :row-height="rowHeight"
      :is-draggable="draggable"
      :is-resizable="resizable"
      :vertical-compact="true"
      :use-css-transforms="true"
    >
      <grid-item v-for="item in layout" :key="item.i"
                 :x="item.x"
                 :y="item.y"
                 :w="item.w"
                 :h="item.h"
                 :min-w="2"
                 :min-h="2"
                 :i="item.i"
                 @resize="resize"
                 @move="move"
                 @resized="resized"
                 @moved="moved"
      >
      </grid-item>
    </grid-layout>
  </div>
</template>

<script>
  /* eslint-disable */

  import VueGridLayout from 'vue-grid-layout'
  let GridLayout = VueGridLayout.GridLayout
  let GridItem = VueGridLayout.GridItem

  const testLayout = [
    {"x":0,"y":0,"w":2,"h":2,"i":"0", resizable: true, draggable: true},
    {"x":2,"y":0,"w":2,"h":4,"i":"1", resizable: null, draggable: null},
    {"x":4,"y":0,"w":2,"h":5,"i":"2", resizable: false, draggable: false},
    {"x":6,"y":0,"w":2,"h":3,"i":"3", resizable: false, draggable: false},
    {"x":8,"y":0,"w":2,"h":3,"i":"4", resizable: false, draggable: false},
    {"x":10,"y":0,"w":2,"h":3,"i":"5", resizable: false, draggable: false},
    {"x":0,"y":5,"w":2,"h":5,"i":"6", resizable: false, draggable: false},
    {"x":2,"y":5,"w":2,"h":5,"i":"7", resizable: false, draggable: false},
    {"x":4,"y":5,"w":2,"h":5,"i":"8", resizable: false, draggable: false},
    {"x":6,"y":4,"w":2,"h":4,"i":"9", resizable: false, draggable: false},
    {"x":8,"y":4,"w":2,"h":4,"i":"10", resizable: false, draggable: false},
    {"x":10,"y":4,"w":2,"h":4,"i":"11", resizable: false, draggable: false},
    {"x":0,"y":10,"w":2,"h":5,"i":"12", resizable: false, draggable: false},
    {"x":2,"y":10,"w":2,"h":5,"i":"13", resizable: false, draggable: false},
    {"x":4,"y":8,"w":2,"h":4,"i":"14", resizable: false, draggable: false},
    {"x":6,"y":8,"w":2,"h":4,"i":"15", resizable: false, draggable: false},
    {"x":8,"y":10,"w":2,"h":5,"i":"16", resizable: false, draggable: false},
    {"x":10,"y":4,"w":2,"h":2,"i":"17", resizable: false, draggable: false},
    {"x":0,"y":9,"w":2,"h":3,"i":"18", resizable: false, draggable: false},
    {"x":2,"y":6,"w":2,"h":2,"i":"19", resizable: false, draggable: false}
  ];


  export default {
    components: {
      GridLayout,
      GridItem
    },
    data () {
      return {
        layout: testLayout,
        draggable: true,
        resizable: true,
        rowHeight: 30,
        colNum: 0,
        index: 0
      }
    },
    mounted: function () {
      this.index = this.layout.length;
    },
    methods: {
      clicked: function() {
        window.alert("CLICK!");
      },
      removeItem: function(item) {
        //console.log("### REMOVE " + item.i);
        this.layout.splice(this.layout.indexOf(item), 1);
      },
      addItem: function() {
        var self = this;
        //console.log("### LENGTH: " + this.layout.length);
        var item = {"x":0,"y":0,"w":2,"h":2,"i":this.index+"", whatever: "bbb"};
        this.index++;
        this.layout.push(item);
      },
      move: function(i, newX, newY){
        console.log("MOVE i=" + i + ", X=" + newX + ", Y=" + newY);
      },
      resize: function(i, newH, newW){
        console.log("RESIZE i=" + i + ", H=" + newH + ", W=" + newW);
      },
      moved: function(i, newX, newY){
        console.log("### MOVED i=" + i + ", X=" + newX + ", Y=" + newY);
      },
      resized: function(i, newH, newW, newHPx, newWPx){
        console.log("### RESIZED i=" + i + ", H=" + newH + ", W=" + newW + ", H(px)=" + newHPx + ", W(px)=" + newWPx);
      },
      /**
       * Add change direction button
       */
      changeDirection() {
        let documentDirection = (document.dir !=undefined) ?
          document.dir :
          document.getElementsByTagName("html")[0].getAttribute("dir");
        let toggle = "";
        if (documentDirection == "rtl") {
          toggle = "ltr"
        } else {
          toggle = "rtl"
        }
        var html = document.getElementsByTagName("html")[0];
        html.setAttribute("dir", toggle);
        //eventBus.$emit('directionchange');
      }
    }
  }
</script>
<style scoped>
  /*** EXAMPLE ***/
  #content {
    width: 100%;
  }

  .vue-grid-layout {
    background: #eee;
  }

  .layoutJSON {
    background: #ddd;
    border: 1px solid black;
    margin-top: 10px;
    padding: 10px;
  }

  .eventsJSON {
    background: #ddd;
    border: 1px solid black;
    margin-top: 10px;
    padding: 10px;
    height: 100px;
    overflow-y: scroll;
  }

  .columns {
    -moz-columns: 120px;
    -webkit-columns: 120px;
    columns: 120px;
  }



  .vue-resizable-handle {
    z-index: 5000;
    position: absolute;
    width: 20px;
    height: 20px;
    bottom: 0;
    right: 0;
    background: url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBzdGFuZGFsb25lPSJubyI/Pg08IS0tIEdlbmVyYXRvcjogQWRvYmUgRmlyZXdvcmtzIENTNiwgRXhwb3J0IFNWRyBFeHRlbnNpb24gYnkgQWFyb24gQmVhbGwgKGh0dHA6Ly9maXJld29ya3MuYWJlYWxsLmNvbSkgLiBWZXJzaW9uOiAwLjYuMSAgLS0+DTwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+DTxzdmcgaWQ9IlVudGl0bGVkLVBhZ2UlMjAxIiB2aWV3Qm94PSIwIDAgNiA2IiBzdHlsZT0iYmFja2dyb3VuZC1jb2xvcjojZmZmZmZmMDAiIHZlcnNpb249IjEuMSINCXhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbDpzcGFjZT0icHJlc2VydmUiDQl4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjZweCIgaGVpZ2h0PSI2cHgiDT4NCTxnIG9wYWNpdHk9IjAuMzAyIj4NCQk8cGF0aCBkPSJNIDYgNiBMIDAgNiBMIDAgNC4yIEwgNCA0LjIgTCA0LjIgNC4yIEwgNC4yIDAgTCA2IDAgTCA2IDYgTCA2IDYgWiIgZmlsbD0iIzAwMDAwMCIvPg0JPC9nPg08L3N2Zz4=');
    background-position: bottom right;
    padding: 0 3px 3px 0;
    background-repeat: no-repeat;
    background-origin: content-box;
    box-sizing: border-box;
    cursor: se-resize;
  }

  .vue-grid-item:not(.vue-grid-placeholder) {
    background: #ccc;
    border: 1px solid black;
  }

  .vue-grid-item.resizing {
    opacity: 0.9;
  }

  .vue-grid-item.static {
    background: #cce;
  }

  .vue-grid-item .text {
    font-size: 24px;
    text-align: center;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
    height: 24px;
  }

  .vue-grid-item .minMax {
    font-size: 12px;
  }

  .vue-grid-item .add {
    cursor: pointer;
  }
</style>
