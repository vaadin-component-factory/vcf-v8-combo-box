import { Debouncer } from '@polymer/polymer/lib/utils/debounce.js';
import { timeOut } from '@polymer/polymer/lib/utils/async.js';
import './vcf-v8-comboBoxConnector.js';
import { ComboBoxPlaceholder } from './src/vcf-v8-combo-box-placeholder.js';

window.Vaadin.Flow.Legacy.Debouncer = Debouncer;
window.Vaadin.Flow.Legacy.timeOut = timeOut;

window.Vaadin.ComboBoxPlaceholder = ComboBoxPlaceholder;