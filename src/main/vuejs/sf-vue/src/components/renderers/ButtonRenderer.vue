<template>
  <span><button style="height: 20px" @click="emitCT">Detail</button></span>
</template>

<script>
  /* eslint-disable */
  export default {
    data () {
      return {}
    },
    methods: {
      emitCT() {
        //console.log(this);
        window.testObj = this;


        //alert(this.params.node.rowIndex +','+ this.params.colDef.headerName)
        //this.params.context.component.parent.emitCT(`Row: ${this.params.node.rowIndex}, Col: ${this.params.colDef.headerName}`)

        //this.params.context.parent.methodFromParent();

        //this.$emit('clickct', this.params.node.rowIndex, this.params.colDef.headerName)
      }
    }
  }
</script>

<style>

</style>
