// http://eslint.org/docs/user-guide/configuring
// /* eslint-disable */ 주석 다음 코드들은 체크 안함
// /* eslint-enable */ 주석 다음부터 다시 체크함
// // disable-eslint-next-line 주석 다음 한 줄만 체크 안함

module.exports = {
  root: true,
  parser: 'babel-eslint',
  parserOptions: {
    sourceType: 'module'
  },
  env: {
    browser: true,
  },
  // https://github.com/feross/standard/blob/master/RULES.md#javascript-standard-style
  extends: 'standard',
  // required to lint *.vue files
  plugins: [
    'html'
  ],
  // add your custom rules here
  'rules': {
    // allow paren-less arrow functions
    'arrow-parens': 0,
    // allow async-await
    'generator-star-spacing': 0,
    // allow debugger during development
    'no-debugger': process.env.NODE_ENV === 'production' ? 2 : 0,
    'comma-spacing': ['off', {before:false, after:false}],
    'key-spacing': ['off', { 'beforeColon': false }],
    'quotes': ["off", "double"],
    semi: ["off", "always"]
  }
}
