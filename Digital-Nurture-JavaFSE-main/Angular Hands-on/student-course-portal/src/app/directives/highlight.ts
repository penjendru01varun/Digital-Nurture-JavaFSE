import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {

  @Input() appHighlight = 'yellow';

  constructor(private element: ElementRef) {}

  @HostListener('mouseenter')
  onMouseEnter() {
    this.element.nativeElement.style.backgroundColor = this.appHighlight;
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.element.nativeElement.style.backgroundColor = '';
  }
}