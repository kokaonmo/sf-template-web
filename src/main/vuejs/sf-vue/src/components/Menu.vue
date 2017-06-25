<template>
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
      <div style="border: 0px dashed #ffffff; background-color: #ffffff;  width: 220px; height: 60px; margin-left: auto; margin-right: auto; padding: 0px; text-align: center; line-height: 54px; vertical-align:middle;">
        <img alt="image" src="img/sf_logo.png" height="40" />
      </div>

      <ul class="nav" id="side-menu">
        <ul class="nav nav-label">
          <li v-for="(item, i) in menu" v-bind:class="{active: !!item.active}">
            <a v-bind:path="item.path || '#'" v-on:click="clickMain(i, $event, item)">
              <i class="fa" v-bind:class="'fa-' + item.fontAwesome"></i>
              <span>{{item.caption}}</span>
              <span v-if="item.submenu" class="fa arrow"></span>
            </a>
            <ul v-if="item.submenu" class="nav nav-second-level" v-bind:class="{collapse: !item.active}">
              <li v-for="(subitem, j) in item.submenu" v-bind:class="{active:subitem.active}"><a v-on:click="clickSub(j, $event, item.submenu, subitem)">{{subitem.caption}}</a></li>
            </ul>
          </li>
        </ul>
        <div style="margin-top: 30%; text-align: center">
          <span style="color: #0e9aef;">Admin (dev@ex-em.com)&nbsp;</span>
          <button style="display: inline-block; width: 40px;" class="btn btn-primary" v-on:click="logout()">X</button>
        </div>

      </ul>
    </div>
  </nav>
</template>

<script>
  /* eslint-disable */
  const testData = [
    {
      caption: '종합대쉬보드',
      fontAwesome: 'industry',
      active: true,
      path: '/',
      menuid: '100000'
    },
    {
      caption: '가동률분석',
      fontAwesome: 'building',
      menuid: '200000',
      active: false,
      submenu: [
        {
          caption: '시간가동률',
          path: 'availability',
          menuid: '200001',
          active: true
        },
        {
          caption: '성능가동률',
          path: 'performance',
          menuid: '200002',
          active: false
        },
        {
          caption: '가동률',
          path: 'operation',
          menuid: '200003',
          active: false
        }
      ]
    },
    {
      caption: '정지현황',
      fontAwesome: 'pie-chart',
      path: 'stopstatus',
      menuid: '300000',
      active: false
    },
    {
      caption: '상관분석',
      fontAwesome: 'coffee',
      path: 'correlation',
      menuid: '400000',
      active: false
    }
  ];

  export default {
    data () {
      return {
        menu: testData
      }
    },
    mounted () {
      let path = this.$router.currentRoute.path.substr(1)
      path = path.length<1?'/':path

      this.menu.forEach(function(v) {
        if(v.submenu){
          v.submenu.forEach(function(v2) {
            if(v2.path == path){
              v.active = true
              v2.active = true
            }else{
              v2.active = false
            }
          })
        }else{
          console.log(v.path, path)
          if(v.path == path){
            v.active = true
          }else{
            v.active = false
          }
        }

      })
    },
    updated () {

    },
    destroyed (){

    },
    methods: {
      clickMain: function(index, e, selectedMenu) {
        console.log(index, selectedMenu);
        this.menu.forEach(function(v, i) {
          v.active = i===index;
        })
        if(selectedMenu.submenu == undefined){
          this.$emit('clickmenu', selectedMenu);
        }else{
          selectedMenu.submenu.forEach(function(v2) {
            v2.active = false
          })
        }
      },

      clickSub: function(index, e, submenu, selectedMenu) {
        submenu.forEach(function(v, i) {
          v.active = i===index;
        })
        this.$emit('clickmenu', selectedMenu);
      },

      logout (){
        location.href = "/logout";
      }
    }
  }
</script>

<style scoped>
  li.active {
    transition: all 0.4s;
    transition-property: all;
    transition-duration: 0.4s;
    transition-timing-function: initial;
    transition-delay: initial;
  }
  .nav > li.active {
      border-left: 4px solid #19aa8d;
      background: #293846;
  }
</style>
