<template>
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
      <div style="border: 0px dashed #ffffff; background-color: #ffffff;  width: 220px; height: 60px; margin-left: auto; margin-right: auto; padding: 0px; text-align: center; line-height: 54px; vertical-align:middle;">
        <img alt="image" src="img/sf_logo.png" height="40" />
      </div>

      <ul class="nav" id="side-menu">
        <ul class="nav nav-label">
          <li v-for="(item, i) in menu" v-bind:class="{active: !!item.active}">
            <a v-bind:href="item.href || '#'" v-on:click="clickMain(i, $event)">
              <i class="fa" v-bind:class="'fa-' + item.fontAwesome"></i>
              <span>{{item.title}}</span>
              <span v-if="item.submenu" class="fa arrow"></span>
            </a>
            <ul v-if="item.submenu" class="nav nav-second-level" v-bind:class="{collapse: !item.active}">
              <li v-for="(subitem, j) in item.submenu"><a v-bind:href="subitem.href" v-on:click="clickSub(j, $event)">{{subitem.title}}</a></li>
            </ul>
          </li>
          <!--li>
            <a href="#">
              <i class="fa fa-dashboard"></i>
              <span class="nav-label">title</span>
            </a>
            <ul class="nav nav-second-level">
              <li><a href="#">children.title</a></li>
            </ul>
          </li-->
        </ul>

      </ul>
    </div>
  </nav>
</template>

<script>
  /* eslint-disable */
//  import '../../node_modules/jquery/dist/jquery.min.js';
//  import '../../node_modules/metismenu/dist/metisMenu.min.css';
//  import '../../node_modules/metismenu/dist/metisMenu.min.js';
  const testData = [
    {
      title: '종합대쉬보드',
      fontAwesome: 'dashboard',
      active: true
//      submenu: [
//        {
//          title: 'menu 1-1',
//          href: 'http://naver.com'
//        },
//        {
//          title: 'menu 1-2',
//          href: 'http://daum.net'
//        }
//      ]
    },
    {
      title: '가동률분석',
      fontAwesome: 'building',
      submenu: [
        {
          title: '시간가동률',
          href: '#'
        },
        {
          title: '성능가동률',
          href: '#'
        },
        {
          title: '가동률',
          href: '#'
        }
      ]
    },
    {
      title: '정지현황',
      fontAwesome: 'envelope',
      href: '#'
    }
  ];

  export default {
    data () {
      return {
        menu: testData,
      }
    },
    mounted: function () {
    },
    methods: {
      clickMain: function(index, e) {
        console.log(index, this);
        this.menu.forEach(function(v, i) {
          v.active = i==index;
        })
      },

      clickSub: function(i, e) {
        console.log(i);
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
