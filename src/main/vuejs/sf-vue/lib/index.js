import * as components from './components';
import * as directives from './directives';

export default {
  install (Vue) {
    // Register components
    for (let component in components) {
      Vue.component(component, components[component]);
    }

    // Register directives
    for (let directive in directives) {
      Vue.directive(directive, directives[directive]);
    }
  }
};
